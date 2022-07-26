//===============================================Загрузка таблицы===============================================//

let vu_36List = {};

const tbodyStart = document.getElementById('tbodyId');

//Запрос к серверу
(async () => {
    let url = 'http://localhost:8080/server/vu36/getlist';
    let response = await fetch(url);
    vu_36List = await response.json();
    renderTable();
})();

//Создание и заполнение таблицы
function renderTable() {
    vu_36List.list.forEach(arrayString => {
        let tableRow = `
            <tr>
            <td>${arrayString.vagnum}</td>
            <td>${arrayString.remtype}</td>
            <td>${arrayString.vag}</td>
            <td>${arrayString.tsn}</td>
            <td><button class="popup-link" data-id="${arrayString.id}">${arrayString.tsk}</button></td>
            <td>${arrayString.snazv}</td>
            </tr>
            `;
        tbodyStart.insertAdjacentHTML('beforeEnd', tableRow);
    });
}

//========================================Работа всплывающих окон===============================================//

let popupLinks = document.querySelectorAll('.popup-link');
const body = document.body;
const lockPadding = document.querySelectorAll('.lock-padding');

let unlock = true;

const timeout = 800;

//Нажатие на кнопку открытия
body.addEventListener("click", function (e) {
    if (!e.target || !e.target.classList.contains('popup-link'))
        return;
    const popupLink = e.target;
    const popupName = 'popup';
    const curentPopup = document.getElementById(popupName);
    let id = popupLink.dataset.id;
    renderMoreInformation(id);
    popupOpen(curentPopup);
    e.preventDefault();
});

//Нажатие на кнопку закрытия
const popupCloseIcon = document.querySelectorAll('.close-popup');
for (let index = 0; index < popupCloseIcon.length; index++) {
    const el = popupCloseIcon[index];
    el.addEventListener('click', function (e) {
        popupClose(el.closest('.popup'));
        e.preventDefault();
    });
}

//Нажатие на кнопку ESC для закрытия
document.addEventListener('keydown', function (e) {
    if (e.which === 27) {
        const popupActive = document.querySelector('.popup.open');
        popupClose(popupActive);
    }
});

//Функция открытия окна
function popupOpen(curentPopup) {
    bodyLock();
    curentPopup.classList.add('open');
    curentPopup.addEventListener("click", function (e) {
        if (!e.target.closest('.popup_content')) {
            popupClose(e.target.closest('.popup'));
        }
    });
}

//Функция закрытия окна
function popupClose(popupActive, doUnlock = true) {
    if (unlock) {
        popupActive.classList.remove('open');
        if (doUnlock) {
            bodyUnLock();
        }
    }
}

//Блокировка фона
function bodyLock() {
    body.classList.add('lock');
    unlock = false;
    setTimeout(function () {
        unlock = true;
    }, timeout);
}

//Разблокировка фона
function bodyUnLock() {
    setTimeout(function () {
        body.classList.remove('lock');
    }, timeout);
    unlock = false;
    setTimeout(function () {
        unlock = true;
    }, timeout);
}

//====================================Загрузка дополнительной информации========================================//

let moreInfo = {};
async function renderMoreInformation(id) {
    let url = `http://localhost:8080/server/vu36/getdoc?id=${id}`;
    let response = await fetch(url);
    moreInfo = await response.json();
    document.querySelector('.id_table').textContent = moreInfo.id;
    document.querySelector('.vagnum_table').textContent = moreInfo.vagnum;
    document.querySelector('.remtype_table').textContent = moreInfo.remtype;
    document.querySelector('.vag_table').textContent = moreInfo.vag;
    document.querySelector('.tsn_table').textContent = moreInfo.tsn;
    document.querySelector('.tsk_table').textContent = moreInfo.tsk;
    document.querySelector('.snazv_table').textContent = moreInfo.snazv;
}

