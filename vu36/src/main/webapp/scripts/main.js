let vu_36List = {};

const tbodyStart = document.getElementById('tbodyId');


(async () => {
    let url = 'http://localhost:8080/server/vu36/getlist';
    let response = await fetch(url);
    vu_36List = await response.json();
    renderTable();
})()

function renderTable() {
    vu_36List.list.forEach(tableField => {
    let tableRow = `
            <tr>
            <td>${tableField.vagnum}</td>
            <td>${tableField.remtype}</td>
            <td>${tableField.vag}</td>
            <td>${tableField.tsn}</td>
            <td>${tableField.tsk}</td>
            <td>${tableField.snazv}</td>
            </tr>
            `
    tbodyStart.insertAdjacentHTML('beforeEnd', tableRow);
})}

