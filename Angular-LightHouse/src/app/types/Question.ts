import { User } from './User';
import { Category } from './Category';

export class Question {
    questionID: number;
    cat: Category;
    user: User;
    questionName: string;
    answers:String[];
    exp: string;
    qRating: number;
    status: string;
}