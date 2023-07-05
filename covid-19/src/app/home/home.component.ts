import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ccovidservice } from '../ccovidservice.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  constructor(private ccovidservice: ccovidservice, private router: Router) { }

  ngOnInit(): void {
    localStorage.setItem("isloggedin","false")
  }

}
