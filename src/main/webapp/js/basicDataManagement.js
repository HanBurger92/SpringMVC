var queriesToDisplay = ['Consumer','Supplier','Product'];
var selectedType;

// display different query option for each selection
function displayQueryOption(option) {


    for(var i=0; i<queriesToDisplay.length; i++){
        selectedType = document.getElementById(queriesToDisplay[i]);
        if (option.value != queriesToDisplay[i]){
            selectedType.style.display='none'
        }else{
            selectedType.style.display='';
        }
    }
}

function insertQuery() {
    selectedType = prompt("which data you want to insert")
    var code = prompt()
}