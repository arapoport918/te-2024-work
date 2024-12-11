const baseURL = "http://www.omdbapi.com/";

function buildRow(movieItem) {
    const tr = document.createElement('tr');
    const posterCell = document.createElement('td');
    const imdbCell = document.createElement('td');
    const titleCell = document.createElement('td');
    const yearCell = document.createElement('td');
    const img = document.createElement('img');

    img.src = movieItem.Poster;
    posterCell.appendChild(img);

    imdbCell.innerText = movieItem.imdbID;
    titleCell.innerText = movieItem.Title;
    yearCell.innerText = movieItem.Year;

    tr.appendChild(posterCell);
    tr.appendChild(imdbCell);
    tr.appendChild(titleCell);
    tr.appendChild(yearCell);

    return tr;
}