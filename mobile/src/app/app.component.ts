import {Component} from '@angular/core';

import {Platform} from '@ionic/angular';
import {SplashScreen} from '@ionic-native/splash-screen/ngx';
import {StatusBar} from '@ionic-native/status-bar/ngx';
import {HttpService} from "./http.service";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html'
})
export class AppComponent {

  constructor(
      private platform: Platform,
      private splashScreen: SplashScreen,
      private statusBar: StatusBar,
      private httpService: HttpService
  ) {
    this.initializeApp();
  }

  initializeApp() {
    this.httpService.get("/form", {RequestID: "AccountData_AccountInformation"})
    .toPromise()
    .then(response => console.log(response.body));


    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }
}
