import { Component, OnInit } from '@angular/core';
import { Config } from 'src/app/_DTO/config';
import { ConfigService } from 'src/app/config/config.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  private configList: Config[];
  private config: Config = new Config;

  constructor(private configService: ConfigService) { }

  ngOnInit() {
    this.loadFirstConfig();
  }

  loadFirstConfig(): void {
    this.configService.getAllConfig().subscribe(
      config => {
        this.configService.getConfig(config[0].id).subscribe(
          config => {
            this.config = config;
          });

        this.configList = config;
      });
  }
}
