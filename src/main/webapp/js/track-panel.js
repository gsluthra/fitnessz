var dayTrackEvent = (function () {
    //PRIVATE VARIABLES AND FUNCTIONS
    var currentSelectedDate;

    logToConsole = function( foo ) {
        console.log( foo );
    };

    return {
        // PUBLIC FUNCTIONS
        storeCurrentDate: function( momentDate ) {
            currentSelectedDate = momentDate;
        },

        getDateForDisplay: function() {
            //Refer to http://momentjs.com/
            var day = currentSelectedDate.format('dddd');
            var dateString = currentSelectedDate.format('LL') + " (" + day + ")";
            return dateString;
        },

        getDateOnly: function() {
            var dateOnlyString = currentSelectedDate.format('LL');
            return dateOnlyString;
        }
    };

})();

function setDateSelected(momentDate) {
    dayTrackEvent.storeCurrentDate(momentDate);
    $("#dateSelected").text(dayTrackEvent.getDateForDisplay());
}

$(document).ready(function() {
    $("#yesToExerciseBtn").on("click",function () {
        console.log("Yes clicked for date: " + dayTrackEvent.getDateOnly());
        var $yesButton = $("#yesToExerciseBtn");
        $yesButton.removeClass("btn-default");
        $yesButton.addClass("btn-success");
     });
 });
