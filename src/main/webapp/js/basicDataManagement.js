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
    $('.updateConsumer').click(function () {
        var consumerCode = $(this).data('consumerCode');
        var consumerName = $(this).data('consumerName');
        var consumerAddress = $(this).data('consumerAddress');
        var contactNumber = $(this).data('contactNumber');
        var faxNumber = $(this).data('faxNumber');
        var linkman = $(this).data('linkman');
        var remark= $(this).data('remark');

        $('input[name=consumerCode]').val(consumerCode);
        $('input[name=consumerName]').val(consumerName);
        $('input[name=consumerAddress]').val(consumerAddress);
        $('input[name=contactNumber]').val(contactNumber);
        $('input[name=faxNumber]').val(faxNumber);
        $('input[name=linkman]').val(linkman);
        $('input[name=remark]').val(remark);
        $('input[name=consumerCode]').prop('readonly',true);

        $('#consumer-update-dialog').dialog({
            autoOpen: false,
            height: 800,
            width: 400,
            modal: true,
            buttons:{
                "Confirm": function () {
                    form = $('#consumerUpdateForm');
                    form.submit();
                },
                "Cancel": function () {
                    $(this).dialog("close");
                }
            }
        })
        $('#consumer-update-dialog').dialog('open');
    });

    $('.updateSupplier').click(function () {
        var supplierCode = $(this).data('supplierCode');
        var supplierName = $(this).data('supplierName');
        var supplierAddress = $(this).data('supplierAddress');
        var contactNumber = $(this).data('contactNumber');
        var faxNumber = $(this).data('faxNumber');
        var linkman = $(this).data('linkman');
        var remark= $(this).data('remark');

        $('input[name=supplierCode]').val(supplierCode);
        $('input[name=supplierName]').val(supplierName);
        $('input[name=supplierAddress]').val(supplierAddress);
        $('input[name=contactNumber]').val(contactNumber);
        $('input[name=faxNumber]').val(faxNumber);
        $('input[name=linkman]').val(linkman);
        $('input[name=remark]').val(remark);
        $('input[name=supplierCode]').prop('readonly',true);
        $('#supplier-update-dialog').dialog({
            autoOpen: false,
            height: 800,
            width: 400,
            modal: true,
            buttons:{
                "Confirm": function () {
                    form = $('#supplierUpdateForm');
                    form.submit();
                },
                "Cancel": function () {
                    $(this).dialog("close");
                }
            }
        })
        $('#supplier-update-dialog').dialog('open');
    });

    $('.updateProduct').click(function () {
        var productCode = $(this).data('productCode');
        var productName = $(this).data('productName');
        var type = $(this).data('type');
        var category = $(this).data('category');
        var unit = $(this).data('unit');
        var cost = $(this).data('cost');
        var price= $(this).data('price');
        var certificate= $(this).data('certificate');
        var expirationDate= $(this).data('expirationDate');

        $('input[name=productCode]').val(productCode);
        $('input[name=productName]').val(productName);
        $('input[name=type]').val(type);
        $('input[name=category]').val(category);
        $('input[name=unit]').val(unit);
        $('input[name=cost]').val(cost);
        $('input[name=price]').val(price);
        $('input[name=certificate]').val(certificate);
        $('input[name=expirationDate]').val(expirationDate);
        $('input[name=productCode]').prop('readonly',true);
        $('#product-update-dialog').dialog({
            autoOpen: false,
            height: 800,
            width: 400,
            modal: true,
            buttons:{
                "Confirm": function () {
                    form = $('#productUpdateForm');
                    form.submit();
                },
                "Cancel": function () {
                    $(this).dialog("close");
                }
            }
        })
        $('#product-update-dialog').dialog('open');
    });
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




