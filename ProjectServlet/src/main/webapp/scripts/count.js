function length_check(len_max, field_id, counter_id) {
    var len_current = document.getElementById(field_id).value.length;
    var rest = len_max - len_current;
    if (len_current > len_max) {
        document.getElementById(field_id).value = document.getElementById(field_id).value.substr(0, len_max);
        if (rest < 0) {
            rest = 0;
        }
        document.getElementById(counter_id).firstChild.data = rest + ' / ' + len_max;
        alert('The maximum length of the field contents of : ' + len_max + ' characters');
    } else {
        document.getElementById(counter_id).firstChild.data = rest + ' / ' + len_max;
    }
}
