export class S3Files {
    bucketName = "lighthouse18882819";
    keyName = "";
    filePath = "";
    category = "";

    constructor(keyName: string, filePath: string, category: string) {
        this.keyName = keyName;
        this.filePath = filePath;
        this.category = category;
    }
}