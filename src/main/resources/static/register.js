function register(id,pw){

    fetch('/dbrcall', {
        method: 'post',
        headers: {
            "Context-Type": 'application/json;'
        },
        body: JSON.stringify({
            id: id,
            pw: pw,
         })
    }).then(r =>r.json())
}


function registerB(){
    let id = document.getElementById("ID").value;
    let pw = document.getElementById("PW").value;
    console.log(id,pw);
    register(id,pw);
}