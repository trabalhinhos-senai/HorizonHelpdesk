import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ConfigService } from './config.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Config } from '../_DTO/config';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})
export class ConfigComponent implements OnInit {

  private configList: Config[];
  private config: Config = new Config;

  constructor(private route: ActivatedRoute,
    private _location: Location,
    private configService: ConfigService) { }

  ngOnInit(): void {
      this.loadFirstConfig();
  }

  onSubmit(formUsuario: NgForm) {
    if (formUsuario.valid) {
      console.log(this.config)
      this.configService.updateConfig(this.config.id, this.config).subscribe(
        config => {
          this.config = config;
          this.backLastPage();
        }
      );
    }
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

  backLastPage() {
    this._location.back();
  }

}
