import fs from "fs";
import path from "path";
import { fileURLToPath } from 'url';

export async function parseJson() {

    const __filename = fileURLToPath(import.meta.url);
    const __dirname = path.dirname(__filename);
    console.log(__filename);
    console.log(__dirname);
    // //convert relative path to absolute path
    //const absolutePath = path.resolve(__dirname, relativePath);
    // console.log(absolutePath);
    //const path = "../src/main/java/DataJson.txt";
    //const path = "/Users/kentn/Documents/projects/WebScraper/src/main/DataJson.txt";
    // fs.readFile(path, (error, data) => {
    //     if (error){
    //         console.log(error);
    //         return;
    //     }

    //     console.log(data);

    // });
    
}