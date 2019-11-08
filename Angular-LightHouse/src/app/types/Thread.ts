import { User } from './User';

export class ForumThread {
    threadID: number;
    postedBy: User;
    title: string;
    contents: string;
    //postDate: Date;
    //postTime: Date;
    topic: string;
    subforum: string;
    //lastPost: Date;
    isReported: boolean;
    sticky: boolean;

    postDate: number[];
    postTime: number[];
    lastPost: number[];

    orderBy: number;
}