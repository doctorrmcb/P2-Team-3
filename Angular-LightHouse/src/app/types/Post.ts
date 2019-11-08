import { ForumThread } from './Thread';
import { User } from './User';

export class Post{
    postID: number;
    threadID: ForumThread;
    posted_by: User;
    contents: string;
    //postDate: Date;
    //postTime: Time;
    isReported: boolean;
    
    postDate: number[];
    postTime: number[];

    orderBy: number;
}