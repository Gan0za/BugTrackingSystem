const $projektSelector = document.querySelector('#projekt__select');
const $typeSelector = document.querySelector('#type__select');
const $userSelector = document.querySelector('#user__select');
const $prioritySelector = document.querySelector('#priority__select');

const renderProjectList = (data) => {
    data.forEach((item) => {
        projektTemplatt = `
            <option value="${item.id}">${item.name}</option>
        `;
        $projektSelector.insertAdjacentHTML('beforeend', projektTemplatt);
    });
}

const getProjectList =  () => {
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

const renderTypeList = (data) => {
    data.forEach((item) => {
        typeTemplatt = `
            <option value="${item.id}">${item.name}</option>
        `;
        $typeSelector.insertAdjacentHTML('beforeend', typeTemplatt);
    });
}

const getTypeList =  () => {
    return fetch('http://localhost:3000/type', {
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

const renderUserList = (data) => {
    data.forEach((item) => {
        userTemplatt = `
            <option value="${item.id}">${item.name}</option>
        `;
        $userSelector.insertAdjacentHTML('beforeend', userTemplatt);
    });
}

const getUserList =  () => {
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

const renderPriorityList = (data) => {
    data.forEach((item) => {
        priorityTemplatt = `
            <option value="${item.id}">${item.name}</option>
        `;
        $prioritySelector.insertAdjacentHTML('beforeend', priorityTemplatt);
    });
}

const getPriorityList =  () => {
    return fetch('http://localhost:3000/priority', {
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

getProjectList().then( (data) => renderProjectList(data));
getTypeList().then( (data) => renderTypeList(data));
getUserList().then( (data) => renderUserList(data));
getPriorityList().then( (data) => renderPriorityList(data));