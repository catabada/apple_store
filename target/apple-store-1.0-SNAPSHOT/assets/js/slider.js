var counter = 0;
var slideFirst = document.querySelector('.slide__first');
var labels = document.querySelectorAll('.slider-banner__label');
for (let i in labels) {
    labels[i].onclick = (e) => {
        e.preventDefault();
        counter = i;
        slideFirst.style.marginLeft = `calc(-100% / 6 * ${i})`;
        labels[i].innerHTML = `
            <label class="slider-banner__label--active"></label>
        `
        for (let j in labels) {
            if (j != i) {
                labels[j].innerHTML = ``;
            }
        }
    }
}

function autoSlider() {
    setInterval(function () {
        slideFirst.style.marginLeft = `calc(-100% / 6 * ${counter})`
        labels[counter].innerHTML = `
            <label class="slider-banner__label--active"></label>
        `
        for (let j in labels) {
            if (j != counter) {
                labels[j].innerHTML = ``;
            }
        }
        counter++;
        if (counter > 5) {
            counter = 0;
        }
    }, 4000)
}
autoSlider();



