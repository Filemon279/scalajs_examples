function myMethod() {
    getServerTime().then(x => {
        let msg = "Server time: " + x
        console.log(msg);
        document.getElementById("ServerTime").innerHTML += msg + "<br/>"
    })
}

myMethod();
myMethod();
myMethod();
