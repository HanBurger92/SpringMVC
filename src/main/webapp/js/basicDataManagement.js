var queriesToDisplay = ['Consumer','Supplier','Product'];
var selectedType;

// Jquery-ui code
$(function(){

    $("#consumer-dialog").dialog({
        autoOpen: false,
        height: 800,
        width: 400,
        modal: true,
        buttons: {
            "Confirm": function () {
               $('#consumerForm').submit();
            },
            "Cancel": function () {
                $(this).dialog("close");
            }
        }
    });

    $("#supplier-dialog").dialog({
        autoOpen: false,
        height: 800,
        width: 400,
        modal: true,
        buttons: {
            "Confirm": function () {
                submitForm();
            },
            "Cancel": function () {
                $(this).dialog("close");
            }
        }
    });

    $("#product-dialog").dialog({
        autoOpen: false,
        height: 800,
        width: 400,
        modal: true,
        buttons: {
            "Confirm": function () {
                submitForm();
            },
            "Cancel": function () {
                $(this).dialog("close");
            }
        }
    });

    // called when "New" button is clicked,
    // to decide which dialog to pop up refers to current selection value
    $('#create-data').click(function () {
        switch ($("#selection :selected").val()) {
            case 'Consumer':
                $('#consumer-dialog').dialog('open');
                break;
            case 'Supplier':
                $('#supplier-dialog').dialog('open');
                break;
            case 'Product':
                $('#product-dialog').dialog('open');
                break;
            case 'none':
                alert("Select which category you want to create new data");
                break;
        }

    })
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
