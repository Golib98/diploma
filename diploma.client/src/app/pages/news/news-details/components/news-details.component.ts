import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {News} from "../../../../../model/News";
import {NewsService} from "../../news.service";
import {MenuListService} from "../../../../services/menu-list.service";
import {MenuItem} from "../../../../../model/MenuItem";

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.scss']
})
export class NewsDetailsComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private newsService: NewsService,
    private menuListService: MenuListService
  ) {
  }

  news: News = {} as News;
  menuItems: MenuItem[];


  ngOnInit() {
    this.route.params.subscribe(value => {
      console.log(value.id);
      this.news = this.newsService.allNews.find(value1 => value1.id === value.id);
    });

    this.menuListService.menuList.then(value => this.menuItems = value);
  }

}
