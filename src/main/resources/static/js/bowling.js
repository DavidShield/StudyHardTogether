var valid_input = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "x", "X", "-", "/"];
function submit() {
    var hits = $("#bowling-current-score").val();
    if(!valid_input.includes(hits)) {
        alert("Invalid Input: " + hits);
    } else {
        $.get( "add",   { value: $("#bowling-current-score").val() })
            .done(function( data ) {
                $("#in-time-score").html("Current Score: " + data.inTimeScore);

                for(var i = 0; i < data.frames.length; i++) {
                    for(var k = 0; k < data.frames[i].numberOfRoll; k++) {
                        if(i == 9 && k > 0) {
                            if(k == 1) {
                                $("#hits td")[2 * i + k].innerHTML = data.frames[i].firstExtraHit;
                            } else if(k == 2) {
                                $("#hits td")[2 * i + k].innerHTML = data.frames[i].secondExtraHit;
                            }
                        } else {
                            $("#hits td")[2 * i + k].innerHTML = data.frames[i].hits[k];
                        }
                    }
                    var sum = 0;
                    for(var j = 0; j <= i; j++) {
                        sum += data.frames[j].frameScore;
                    }
                    $("#frame-scores td")[i].innerHTML = sum;
                }
            });
    }
}

function restart() {
    $.get( "restart");
    location.reload();
}