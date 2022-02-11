const $userSelector = document.querySelector('#users__select');
const $postSelector = document.querySelector('#post__select');
const $authoritySelector = document.querySelector('#authority__select');

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

const renderPostList = (data) => {
    data.forEach((item) => {
        postTemplatt = `
            <option value="${item.id}">${item.name}</option>
        `;
        $postSelector.insertAdjacentHTML('beforeend', postTemplatt);
    });
}

const getPostList =  () => {
    return fetch('http://localhost:3000/post', {
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

const renderAuthorityList = (data) => {
    data.forEach((item) => {
        authorityTemplatt = `
            <option value="${item.id}">${item.name}</option>
        `;
        $authoritySelector.insertAdjacentHTML('beforeend', authorityTemplatt);
    });
}

const getAuthorityList =  () => {
    return fetch('http://localhost:3000/authority', {
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

getUserList().then( (data) => renderUserList(data));
getPostList().then( (data) => renderPostList(data));
getAuthorityList().then( (data) => renderAuthorityList(data));
