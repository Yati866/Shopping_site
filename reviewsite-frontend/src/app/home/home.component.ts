import { Component, OnInit } from '@angular/core';
import { HomestatsService } from '../homestats.service';
import { Stats } from '../stats';
 

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  stat :Stats = new Stats();
  tasks : any
  task = "";
  name = "";
reviewArr :any=[];
  constructor(private homestatsService : HomestatsService) { }

  ngOnInit(): void {
    this.getTasksFromService();
    
  }
  getTasksFromService() {
    let observable = this.homestatsService.getPokemon();
    observable.subscribe((data) => {
      this.tasks = JSON.parse( JSON.stringify(data));
      this.reviewArr.push(data);
      console.log(data);
    });

}

}
