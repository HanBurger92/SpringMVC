var queriesToDisplay = ['Consumer','Supplier','Product'];
var selectedType;

// Jquery-ui code
$(function () {
    var dialog;
    var form;

    function addData() {
        
    }
    
    dialog = $("#dialog-form").dialog({
        autoOpen: false,
        height: 800,
        width: 400,
        modal: true,
        buttons:{
            "create new data": addData(),
            "Cancel": function () {
                dialog.dialog("close");
            }
        }
    });

    $("#create-data").button().on("click", function () {
        dialog.dialog("open");
    });
});
// end of Jquery-ui


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
