var queriesToDisplay = ['Consumer','Supplier','Product'];
var selectedType;
var list;
var form;

// Jquery-ui code
$(function(){

    // alert message after insertion
    var msg = $('#message').val();
    if(msg != ''){
        alert(msg);
    }

    $("#consumer-dialog").dialog({
        autoOpen: false,
        height: 800,
        width: 400,
        modal: true,
        buttons: {
            "Confirm": function () {
                form = $('#consumerForm');
                form.submit();
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
                form = $('#supplierForm');
                form.submit();
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
                form = $('#productForm');
                form.submit();
            },
            "Cancel": function () {
                $(this).dialog("close");
            }
        }
    });

    // Write to Cookie when "Search" is clicked
    $('.formButton').click(function () {
        var selection = $("#selection").val();
        document.cookie = "selection=" + selection;
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
    });

    //Update dialog
    $('#updateConsumer').click(function () {
        var consumerCode = $(this).data('consumerCode');
        $('#consumerCode').val(consumerCode);
        $('#consumerCode').prop('disabled',true);
        $('#consumer-dialog').dialog('open');
        $('#consumer-dialog').dialog({
            title: 'Update data',
            buttons:{
                "Confirm": function () {
                    form = $('#consumerForm');
                    form.attr("action","${pageContext.request.contextPath}/mainPage/basicDataManagement/consumerUpdate");
                    alert(form.attr("action"));
                },
                "Cancel": function () {
                    $(this).dialog("close");
                }
            }
        })
    });

    $('#updateSupplier').click(function () {
        var supplierCode = $(this).data('supplierCode');
        $('#supplierCode').val(supplierCode);
        $('#supplierCode').prop('disabled',true);
        $('#supplier-dialog').dialog('open');
        $('#supplier-dialog').dialog({
            title: 'Update data',
            buttons:{
                "Confirm": function () {
                    form = $('#supplierForm');
                    form.attr("action","${pageContext.request.contextPath}/mainPage/basicDataManagement/supplierUpdate");
                    alert(form.attr("action"));
                },
                "Cancel": function () {
                    $(this).dialog("close");
                }
            }
        })
    });

    $('#updateProduct').click(function () {
        var productCode = $(this).data('productCode');
        $('#productCode').val(productCode);
        $('#productCode').prop('disabled',true);
        $('#product-dialog').dialog('open');
        $('#product-dialog').dialog({
            title: 'Update data',
            buttons:{
                "Confirm": function () {
                    form = $('#supplierForm');
                    form.attr("action","${pageContext.request.contextPath}/mainPage/basicDataManagement/productUpdate");
                    alert(form.attr("action"));
                },
                "Cancel": function () {
                    $(this).dialog("close");
                }
            }
        })
    })

});
// end of Jquery-ui

// display different query option for each selection
function displayQueryOption(option) {

    for(var i=0; i<queriesToDisplay.length; i++){
        selectedType = document.getElementById(queriesToDisplay[i]);
        if (option.value != queriesToDisplay[i]){
            selectedType.style.display='none';
        }else{
            selectedType.style.display='';
        }
    }
}




