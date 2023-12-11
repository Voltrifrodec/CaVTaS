import { Component } from '@angular/core';
import { TestService } from './services/test.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'cavtas-fe';

  information?: number;

  constructor(private testService: TestService) {
    this.testService.getAllValues().pipe().subscribe((response) => {
      this.information = response.length;
      console.log(response);
    });
  }

}
