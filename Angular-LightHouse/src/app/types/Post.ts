import { Thread } from './Thread';
import { User } from './User';

export class Post{
    postID: number;
    threadID: Thread;
    posted_by: User;
    contents: string;
    //postDate: Date;
    //postTime: Time;
    isReported: boolean;
    
    postDate: number[];
    postTime: number[];

}