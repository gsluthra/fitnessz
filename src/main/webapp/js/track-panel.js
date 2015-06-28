var dayTrackEvent = (function () {
    //PRIVATE VARIABLES AND FUNCTIONS
    var currentSelectedDate;

    logToConsole = function( foo ) {
        console.log( foo );
    };

    return {
        // PUBLIC FUNCTIONS

        setSelectedDateToNow: function(){
            currentSelectedDate = moment();
        },

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

function resetAllExerciseButtons() {
    $("#yesToExerciseBtn").removeClass("btn-success");
    $("#yesToExerciseBtn").addClass("btn-default");

    $("#noToExerciseBtn").removeClass("btn-danger");
    $("#noToExerciseBtn").addClass("btn-default");

    //TODO: also need to trigger event clearning from backend
}

function resetAllFoodButtons() {
    $("#healthyFoodBtn").removeClass("btn-success");
    $("#healthyFoodBtn").addClass("btn-default");

    $("#normalFoodBtn").removeClass("btn-warning");
    $("#normalFoodBtn").addClass("btn-default");

    $("#badFoodBtn").removeClass("btn-danger");
    $("#badFoodBtn").addClass("btn-default");

    //TODO: also need to trigger event clearning from backend
}

//ON READY REGISTER EVENT LISTENERS
$(document).ready(function() {
    dayTrackEvent.setSelectedDateToNow();

    $("#yesToExerciseBtn").on("click",function () {
        resetAllExerciseButtons();
        console.log("Yes clicked for date: " + dayTrackEvent.getDateOnly());
        var $yesButton = $("#yesToExerciseBtn");
        $yesButton.removeClass("btn-default");
        $yesButton.addClass("btn-success");
     });

    $("#noToExerciseBtn").on("click",function () {
        resetAllExerciseButtons();
        console.log("No clicked for date: " + dayTrackEvent.getDateOnly());
        var $noButton = $("#noToExerciseBtn");
        $noButton.removeClass("btn-default");
        $noButton.addClass("btn-danger");
     });

    $("#clearAllExerciseBtn").on("click",function () {
        resetAllExerciseButtons();
     });



    $("#healthyFoodBtn").on("click",function () {
        resetAllFoodButtons();
        var $yesButton = $("#healthyFoodBtn");
        $yesButton.removeClass("btn-default");
        $yesButton.addClass("btn-success");
     });

    $("#normalFoodBtn").on("click",function () {
        resetAllFoodButtons();
        var $yesButton = $("#normalFoodBtn");
        $yesButton.removeClass("btn-default");
        $yesButton.addClass("btn-warning");
     });

    $("#badFoodBtn").on("click",function () {
        resetAllFoodButtons();
        var $yesButton = $("#badFoodBtn");
        $yesButton.removeClass("btn-default");
        $yesButton.addClass("btn-danger");
     });

    $("#clearnAllFoodBtn").on("click",function () {
        resetAllFoodButtons();
     });
 });
