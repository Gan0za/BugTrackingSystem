from unicodedata import name
from xml.dom.expatbuilder import parseString
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
import uvicorn

import db_helper
import csv_helper
import const
		
app= FastAPI()
app.add_middleware(
	CORSMiddleware,
	allow_credentials=True,
	allow_origins=["*"],
	allow_methods=["*"],
	allow_headers=["*"],
)

@app.get('/post')
def post_list():
	"""
	Получение списка должностей
	"""
	sql = """
		select
			po.postid as id,
			po.namepost as name
		from public.post as po;
	"""
	return db_helper.execute_query(sql)

@app.get('/authority')
def authority_list():
	"""
	Получение списка ролей
	"""
	sql = """
		select
			au.authorityid as id,
			au.nameauthority as name
		from public.authority as au;
	"""
	return db_helper.execute_query(sql)

@app.get('/priority')
def priority_list():
	"""
	Получение списка приоритетов
	"""
	sql = """
		select
			pr.priorityid as id,
			pr.namepriority as name
		from public.priority as pr;
	"""
	return db_helper.execute_query(sql)

@app.get('/type')
def type_list():
	"""
	Получение списка типов 
	"""
	sql = """
		select
			ty.typeid as id,
			ty.nametype as name
		from public.type as ty;
	"""
	return db_helper.execute_query(sql)

@app.get('/projects/{name}/{export}')
def search_project(name: str, export: str):
	"""
		Выдача проектов по фильтру
	"""
	sql = f"""
		select
			pr.idproject as id,
			pr.nameproject as name,
			pr.descriptionProject as description,
			COUNT (tas.idtask) as activ__tasks
		from public.project as pr
		inner join public.Task as tas 
			on pr.IdProject = tas.ProjectId
		where ActivProject <> 0
	"""
	if (name != "NULL"):
		sql += f" AND pr.nameproject like '%{name}%'"
	
	sql += " GROUP BY pr.idproject, pr.nameproject, pr.descriptionProject;"

	if (export == "true"):
		csv_helper.save_file(db_helper.execute_query(sql), "export_project")
		return {'file': open('./server/temp_files/export_project.csv', 'rb')}
	elif (export == "false"):
		return db_helper.execute_query(sql)

@app.get('/tasks/{project}/{type}/{user}/{priority}/{text}/{export}')
def search_tasks(project: str, type: str, user: str, priority: str, text: str, export: str):
	"""
	Получение списка задач с условием
	"""
	sql = f"""
		select
			t.idtask as id,
			t.TopicTask as topic_task,
			pr.NameProject as project,
			ty.NameType as type,
			pri.NamePriority as priority,
			us.SurnameUser as user,
			t.descriptionTask as description
		from task as t
		inner join public.Project as pr 
			on t.ProjectId = pr.IdProject
		inner join public.Type as ty
			on t.TypeId = ty.TypeId
		inner join public.Priority as pri
			on t.PriorityId = pri.PriorityId
		inner join public.user as us
			on t.UserId = us.IdUser
		where t.idtask > 0
	"""
	if (project != '0'):
		sql += f" AND t.projectid = {project}"
	if (type != '0'):
		sql += f" AND t.typeid = {type}"
	if (priority != '0'):
		sql += f" AND t.priorityid = {priority}"
	if (user != '0'):
		sql += f" AND t.userid = {user}"
	if (text != 'NULL'):
		sql += f" AND (t.topictask like '%{text}%' OR t.descriptiontask  like '%{text}%');"

	if (export == "true"):
		csv_helper.save_file(db_helper.execute_query(sql), "export_tasks")
		return {'file': open('./server/temp_files/export_tasks.csv', 'rb')}
	elif (export == "false"):
		return db_helper.execute_query(sql)

@app.get('/users/{id}/{post}/{authority}/{text}/{export}')
def users_search_list(id: str, post: str, authority: str, text: str, export: str):
	"""
	Получение списка пользователей по фильтру
	"""
	sql="""
		select
			us.iduser as id,
			concat(us.SurnameUser, ' ',
			us.NameUser, ' ',
			us.MiddleNameUser) as name,
			po.NamePost as post,
			au.NameAuthority as authority,
			us.descriptionUser as description
		from public.user as us
		inner join public.post as po 
			on us.PostUser = po.PostId
		inner join public.authority as au 
			on us.authorityUser = au.authorityId
		where ActivUser <> 0
	"""
	if (id != '0'):
		sql += f" AND us.iduser = {id}"
	if (post != '0'):
		sql += f" AND us.postuser = {post}"
	if (authority != '0'):
		sql += f" AND us.authorityuser = {authority}"
	if (text != 'NULL'):
		sql += f""" AND (concat(us.SurnameUser, ' ',
			us.NameUser, ' ',
			us.MiddleNameUser) LIKE '%{text}%' OR 
			us.descriptionUser LIKE '%{text}%')"""
	if (export == "true"):
		csv_helper.save_file(db_helper.execute_query(sql), "export_users")
		return {'file': open('./server/temp_files/export_users.csv', 'rb')}
	elif (export == "false"):
		return db_helper.execute_query(sql)


if __name__== '__main__':
	uvicorn.run (app,host=const.APP_IP, port= const.APP_PORT)