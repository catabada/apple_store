const hour = document.querySelector("#hour");
const minute = document.querySelector("#minute");
const second = document.querySelector("#second");
var h = JSON.parse(hour.innerHTML);
var m = JSON.parse(minute.innerHTML);
var s = JSON.parse(second.innerHTML) - 1;
setInterval(() => {
    if (s == -1) {
        s = 59;
        m--;
        if(m == -1) {
            m = 59;
            h--;
        }
    }
        second.innerHTML = JSON.parse(s--) ;
        minute.innerHTML = JSON.parse(m) ;
        hour.innerHTML = JSON.parse(h) ;
}, 1000)