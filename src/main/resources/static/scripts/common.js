function domContentLoaded(){
    
        // let loading = window.document.body.querySelector("#loading");
        // loading.classList.add("visible");

        attachEvents();
    
}

function onLoad(){
    setTimeout(function(){
        let loading = window.document.body.querySelector("#loading");
        let cover = window.document.body.querySelector("#cover");
        loading.classList.remove("visible");
        cover.classList.remove("visible");

        window.document.body.classList.remove("loading");
    }, 3000);
}

function attachEvents() {
    let project = window.document.body.querySelector("div.proj-img");
    project.addEventListener("hover", function() {
        let info = window.document.body.querySelector("div.info-exam");
        info.setAttribute('visibility', '');
    });

    // let contactForm = window.document.body.querySelector("#contact-form");
    // if (contactForm !== null) {
    //     contactForm.onsubmit = function () {
    //         function callback() {
    //             alert("작성이 완료되었습니다.");
    //         }
    //         function fallback() {
    //             alert("예상치 못한 오류가 발생하였습니다. 잠시 후 다시 시도해주세요.");
    //         }
    //         let formData = new FormData(contactForm);
    //         xhr("POST", "/contact", callback, fallback, formData);
    //     }
    // }
}
attachEvents();

function xhr(method, url, callback, fallback, formData) {
    let xhr = new XMLHttpRequest();
    xhr.open(method,url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status >= 200 && xhr.status < 300) {

                callback(xhr.responseText);
            } else {

                fallback();
            }
        }
    };
    if (typeof(formData) == "undefined") {
        xhr.send();
    } else {
        xhr.send(formData);
    }

}



window.document.addEventListener("DOMContentLoaded", domContentLoaded);

window.addEventListener("load", onLoad);