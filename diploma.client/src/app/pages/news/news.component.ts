import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";
import {NewsService} from "./news.service";
import {News} from "../../../model/News";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {

  menuItems: MenuItem[] = [];
  news: News[];

  constructor(
    private menuListService: MenuListService,
    private newsService: NewsService,
  ) {
  }

  async ngOnInit() {
    this.menuItems = await this.menuListService.menuList;
    this.news = await this.newsService.news;

    this.news.forEach(value => {
      value.publishedAt = new Date(value.publishedAt);
    });

    console.log('news', this.news);

  }


}
