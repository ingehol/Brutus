export const userService = {
    fetchData,
    postData,
    deleteData
};

async function fetchData(link) {
    const host = 'http://localhost:8080/api'+link;
    console.log("string: " + host);
     const res = await fetch(host, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' },
    });
    if(res.status >= 200 && res.status <= 299){
        return await res.json();
    }
    else{
        return null;
    }
}

async function postData(link, data){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data),
        credentials: 'include'
    };
   const res = fetch(link, requestOptions);

   return (await res).status;      
}

async function deleteData(link, seq) {
    const host = 'http://localhost:8080/api';
    const requestOptions = {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' },
    };
    console.log(seq)
    console.log(host+link+"/"+seq)
    fetch(host+link+"/"+seq, requestOptions);
}