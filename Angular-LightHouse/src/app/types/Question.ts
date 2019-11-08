import { User } from './User';
import { Category } from './Category';

export class Question {
    user: User;
    category: Category;
    questionName: string;
    answers:String[];
    explanation: string;
    questionRating: number;
    status: string;
}