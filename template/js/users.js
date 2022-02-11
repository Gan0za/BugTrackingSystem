const $usersSelector = document.querySelector('.users');
const $userTemplate = document.querySelector('#user__template').content;

const renderList = (data) => {
    $usersSelector.innerHTML = '';
    data.forEach(renderItem);
}

const renderItem = (item) => {
    const $userElement = $userTemplate.cloneNode(true);
    $userElement.querySelector('.name').textContent = item.name;
    $userElement.querySelector('.post').textContent = item.post;
    $userElement.querySelector('.authority').textContent = item.authority;
    $userElement.querySelector('.description').textContent = item.description;
    $usersSelector.appendChild($userElement);
}

const getItems =  () => {
    return fetch('http://localhost:3000/users/0/0/0/NULL/false/', {
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

const search__users = () => {
    users__select = document.getElementById('users__select').value;
    post__select = document.getElementById('post__select').value;
    like__text__search = document.getElementById('like__text__search').value;
    authority__select = document.getElementById('authority__select').value;

    if (like__text__search == "") {
        like__text__search = "NULL"
    }

    fetch('http://localhost:3000/users/' + users__select + '/' +
        + post__select + '/' + authority__select + '/' + like__text__search + "/false/", {
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
document.getElementById('search__users').onclick = () => search__users();
document.getElementById('like__text__search').onkeypress = function(e) {
    if(e.key=='Enter') search__users();
}

document.getElementById('export').onclick = function() {
    users__select = document.getElementById('users__select').value;
    post__select = document.getElementById('post__select').value;
    like__text__search = document.getElementById('like__text__search').value;
    authority__select = document.getElementById('authority__select').value;

    if (like__text__search == "") {
        like__text__search = "NULL"
    }

    fetch('http://localhost:3000/users/' + users__select + '/' +
        + post__select + '/' + authority__select + '/' + like__text__search + "/true/", {
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

    window.open('../server/temp_files/export_users.csv');
}