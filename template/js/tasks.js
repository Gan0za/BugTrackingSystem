const $tasksSelector = document.querySelector('.tasks');
const $taskTemplate = document.querySelector('#task__template').content;

const renderList = (data) => {
    $tasksSelector.innerHTML = '';
    data.forEach(renderItem);
}
const renderItem = (item) => {
    const $taskElement = $taskTemplate.cloneNode(true);
    const $setings__img = $taskElement.querySelector('.setings__img');

    $taskElement.querySelector('.topic_task').textContent = item.topic_task;
    $taskElement.querySelector('.project').textContent = item.project;
    $taskElement.querySelector('.type').textContent = item.type;
    $taskElement.querySelector('.priority').textContent = item.priority;
    $taskElement.querySelector('.user').textContent = item.user;
    $taskElement.querySelector('.description').textContent = item.description;
    $tasksSelector.appendChild($taskElement);

    $setings__img.addEventListener('click', (event) => {
        event.preventDefault();
        alert(item.id);
    });
}

const getItems =  () => {
    return fetch('http://localhost:3000/tasks/0/0/0/0/NULL/false/', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then((res) => {
        if(res.ok){
            return res.json();
        }
        console.log("Ошибка при получении данных!");
        return Promise.reject();
    });
}

getItems().then( (data) => renderList(data));

const search__tasks = () => {
    projekt__select = document.getElementById('projekt__select').value;
    type__select = document.getElementById('type__select').value;
    user__select = document.getElementById('user__select').value;
    priority__select = document.getElementById('priority__select').value;
    like__text__search = document.getElementById('like__text__search').value;

    if (like__text__search == "") {
        like__text__search = "NULL"
    }

    fetch('http://localhost:3000/tasks/' + projekt__select + '/' +
        + type__select + '/' + user__select + '/' + priority__select + 
        '/' + like__text__search + '/false/', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then((res) => {
        if(res.ok){
            return res.json();
        }
        console.log("Ошибка при получении данных!");
        return Promise.reject();
    }).then( (data) => renderList(data));
    
}
document.getElementById('search__tasks').onclick = () => search__tasks();
document.getElementById('like__text__search').onkeypress = function(e) {
    if(e.key=='Enter') search__tasks();
}

document.getElementById('export').onclick = function() {
    projekt__select = document.getElementById('projekt__select').value;
    type__select = document.getElementById('type__select').value;
    user__select = document.getElementById('user__select').value;
    priority__select = document.getElementById('priority__select').value;
    like__text__search = document.getElementById('like__text__search').value;

    if (like__text__search == "") {
        like__text__search = "NULL"
    }

    fetch('http://localhost:3000/tasks/' + projekt__select + '/' +
        + type__select + '/' + user__select + '/' + priority__select + 
        '/' + like__text__search + '/true/', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then((res) => {
        if(res.ok){
            return res.json();
        }
        console.log("Ошибка при получении данных!");
        return Promise.reject();
    });
    window.open('../server/temp_files/export_tasks.csv');
}

document.getElementById('refresh').onclick = function() {
	location.reload();
}