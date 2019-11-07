import { User } from './User';
import { Category } from './Category';

export class Question {
    user: User;
    category: Category;
    questionName: string;
    correctAnswer: string;
    wrongAnswer1: string;
    wrongAnswer2: string;
    wrongAnswer3: string;
    explanation: string;
    questionRating: number;
    status: string;
}