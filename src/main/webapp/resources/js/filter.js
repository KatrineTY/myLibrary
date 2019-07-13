function filterBooks() {
    let genres = [];
    let i;

    document.getElementsByName("genre").forEach(function (item) {
        if (item.checked) {
            genres.push(item.value.toUpperCase().trim());
        }
    });

    let tr = document.getElementById("bookTable").getElementsByTagName("tr");
    let td;
    if (genres.length !== 0) {
        for (i = 1; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[2];
            if (td) {
                if (genres.includes(td.innerText.toUpperCase())) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    } else {
        for (i = 1; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[2];
            tr[i].style.display = "";
        }
    }
}