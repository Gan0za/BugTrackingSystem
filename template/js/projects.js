const $projectsSelector = document.querySelector('.projects');
const $projectTemplate = document.querySelector('#project__template').content;

const renderList = (data) => {
    $projectsSelector.innerHTML = '';
    data.forEach(renderItem);
}
const renderItem = (item) => {
    const $projectElement = $projectTemplate.cloneNode(true);
    $projectElement.querySelector('.name').textContent = item.name;
    $projectElement.querySelector('.description').textContent = item.description;
    $projectElement.querySelector('.activ__tasks').textContent = item.activ__tasks;
    $projectsSelector.appendChild($projectElement);
}

const getItems =  () => {
    return fetch('http://localhost:3000/projects/NULL/false/', {
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

document.getElementById('refresh').onclick = function() {
	location.reload();
}

document.getElementById('export').onclick = function() {
    name_project = document.getElementById('like__text__search').value;

    if (name_project == "")
        name_project = "NULL";
    
        fetch('http://localhost:3000/projects/' + name_project + '/true/', {
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
    window.open('../server/temp_files/export_project.csv');
}

const search__projects = () => {
    name_project = document.getElementById('like__text__search').value;

    if (name_project == "")
        name_project = "NULL";

    fetch('http://localhost:3000/projects/' + name_project + '/false/', {
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
document.getElementById('search__projects').onclick = () => search__projects();
document.getElementById('like__text__search').onkeypress = function(e) {
    if(e.key=='Enter') search__projects();
}
