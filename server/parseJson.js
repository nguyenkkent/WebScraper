import fs from "fs";

export async function parseJson(path) {
    fs.readFile(path, (error, data) => {
        if (error){
            console.log(error);
            return;
        }
        console.log(data);
    });
    
}