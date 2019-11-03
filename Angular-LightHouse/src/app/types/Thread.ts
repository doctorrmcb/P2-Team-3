import { User } from './User';

export class Thread {
    threadID: number;
    user: User;
    title: string;
    contents: string;
    postDate: Date;
    postTime: Date;
    topic: string;
    subforum: string;
    lastPost: Date;
    isReported: boolean;
}