function setDateSelected(momentDate) {
    //Refer to http://momentjs.com/
    var day = momentDate.format('dddd');
    var dateString = momentDate.format('LL') + " (" + day + ")";
    $("#dateSelected").text(dateString);
}
