var queriesToDisplay = ['Consumer','Supplier','Product'];
var selectedType;
var list;
var form;

// Jquery-ui code
$(function(){

    // alert message after action
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

    $('#consumerForm').validate({
        rules: {
            consumerCode: {
                required: true,
                maxlength: 10
            },
            consumerName: {
                required: true,
                maxlength: 10
            },
            consumerAddress: {
                required: true,
                maxlength: 20
            },
            contactNumber: {
                required: true,
                maxlength: 20
            },
            faxNumber: {
                required: true,
                maxlength: 20
            },
            linkman:{
                required: true,
                maxlength: 10
            },
            remark: {
                required: true,
                maxlength: 50
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

    $('#supplierForm').validate({
        rules: {
            supplierCode: {
                required: true,
                maxlength: 10
            },
            supplierName: {
                required: true,
                maxlength: 10
            },
            supplierAddress: {
                required: true,
                maxlength: 20
            },
            contactNumber: {
                required: true,
                maxlength: 20
            },
            faxNumber: {
                required: true,
                maxlength: 20
            },
            linkman:{
                required: true,
                maxlength: 10
            },
            remark: {
                required: true,
                maxlength: 50
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

    $('#productForm').validate({
        rules:{
            productCode:{
                required: true,
                maxlength: 10
            },
            productName:{
                required: true,
                maxlength: 10
            },
            type: {
                required: true,
                maxlength: 5
            },
            category:{
                required: true,
                maxlength: 5
            },
            unit:{
                required: true,
                maxlength: 10
            },
            cost:{
                required: true,
                number: true,
                max: 1000000
            },
            price:{
                required: true,
                max: 1000000
            },
            certificate:{
                required: true,
                maxlength: 20
            },
            expirationDate:{
                required: true,
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

        $('#consumerCodeUpdate').val(consumerCode);
        $('#consumerNameUpdate').val(consumerName);
        $('#consumerAddressUpdate').val(consumerAddress);
        $('#contactNumberUpdate').val(contactNumber);
        $('#faxNumberUpdate').val(faxNumber);
        $('#linkmanUpdate').val(linkman);
        $('#remarkUpdate').val(remark);
        $('#consumerCodeUpdate').prop('readonly',true);

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
        });
        $('#consumer-update-dialog').dialog('open');
    });

    $('#consumerUpdateForm').validate({
        rules: {
            consumerCode: {
                required: true,
                maxlength: 10
            },
            consumerName: {
                required: true,
                maxlength: 10
            },
            consumerAddress: {
                required: true,
                maxlength: 20
            },
            contactNumber: {
                required: true,
                maxlength: 20
            },
            faxNumber: {
                required: true,
                maxlength: 20
            },
            linkman:{
                required: true,
                maxlength: 10
            },
            remark: {
                required: true,
                maxlength: 50
            }
        }
    });

    $('.updateSupplier').click(function () {
        var supplierCode = $(this).data('supplierCode');
        var supplierName = $(this).data('supplierName');
        var supplierAddress = $(this).data('supplierAddress');
        var contactNumber = $(this).data('contactNumber');
        var faxNumber = $(this).data('faxNumber');
        var linkman = $(this).data('linkman');
        var remark= $(this).data('remark');

        $('#supplierCodeUpdate').val(supplierCode);
        $('#supplierNameUpdate').val(supplierName);
        $('#supplierAddressUpdate').val(supplierAddress);
        $('#contactNumberUpdate').val(contactNumber);
        $('#faxNumberUpdate').val(faxNumber);
        $('#linkmanUpdate').val(linkman);
        $('#remarkUpdate').val(remark);
        $('#supplierCodeUpdate').prop('readonly',true);
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
        });
        $('#supplier-update-dialog').dialog('open');
    });

    $('#supplierUpdateForm').validate({
        rules: {
            supplierCode: {
                required: true,
                maxlength: 10
            },
            supplierName: {
                required: true,
                maxlength: 10
            },
            supplierAddress: {
                required: true,
                maxlength: 20
            },
            contactNumber: {
                required: true,
                maxlength: 20
            },
            faxNumber: {
                required: true,
                maxlength: 20
            },
            linkman:{
                required: true,
                maxlength: 10
            },
            remark: {
                required: true,
                maxlength: 50
            }
        }
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

        $('#productCodeUpdate').val(productCode);
        $('#productNameUpdate').val(productName);
        $('#typeUpdate').val(type);
        $('#categoryUpdate').val(category);
        $('#unitUpdate').val(unit);
        $('#costUpdate').val(cost);
        $('#priceUpdate').val(price);
        $('#certificateUpdate').val(certificate);
        $('#expirationDateUpdate').val(expirationDate);
        $('#productCodeUpdate').prop('readonly',true);
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
        });
        $('#product-update-dialog').dialog('open');
    });

    $('#productUpdateForm').validate({
        rules:{
            productCode:{
                required: true,
                maxlength: 10
            },
            productName:{
                required: true,
                maxlength: 10
            },
            type: {
                required: true,
                maxlength: 5
            },
            category:{
                required: true,
                maxlength: 5
            },
            unit:{
                required: true,
                maxlength: 10
            },
            cost:{
                required: true,
                number: true,
                max: 1000000
            },
            price:{
                required: true,
                max: 1000000
            },
            certificate:{
                required: true,
                maxlength: 20
            },
            expirationDate:{
                required: true
            }
        }
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




