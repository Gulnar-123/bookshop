import { Component, Input } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons/faStar';
@Component({
  selector: 'app-rating',
  imports: [FontAwesomeModule],
  templateUrl: './rating.component.html',
  styleUrl: './rating.component.css'
})
export class RatingComponent {
  faStar = faStar;
  
  @Input() rating: number = 0;
  @Input() readonly: boolean = false;

  setRating(value: number) {
    if (this.readonly) return;
    this.rating = value;
    localStorage.setItem("rating",""+this.rating)
  }
}
