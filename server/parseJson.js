import fs from "fs";
import path from "path";
import { fileURLToPath } from 'url';

export async function parseJson(relativePath) {
    console.log("relative path: ", relativePath);
    const __filename = fileURLToPath(import.meta.url);
    const __dirname = path.dirname(__filename);

    //convert relative path to absolute path
    const absolutePath = path.resolve(__dirname, relativePath);
    console.log("absolute path: ", absolutePath);

    fs.readFile(absolutePath,'utf8', (error, data) => {
        if (error){
            console.log(error);
            return;
        }
        console.log(data);

    });
    
}