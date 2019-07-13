
function author() {
    var input, filter, table, tr, td, i;
    input = document.getElementById("inputAuthor");
    filter = input.value.toUpperCase();
    table = document.getElementById("bookTable");
    tr = table.getElementsByTagName("tr");
    for (i = 1; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            if (td.innerText.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}