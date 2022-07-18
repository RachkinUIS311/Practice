const vu_36List = '';
(async () => {
    let url = '';
    let response = await fetch(url);
    list = await response.json();

})()

const tbodyStart = document.getElementById('tbodyId');
vu_36List.forEach(tableField => {
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
})