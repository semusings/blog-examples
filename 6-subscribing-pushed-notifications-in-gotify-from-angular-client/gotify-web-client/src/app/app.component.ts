import {Component, OnInit} from '@angular/core';
import {WebSocketStore} from './web-stocket-store';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'gotify-web-client';

  socket: WebSocketStore;
  messages: string[] = [];
  name: string;

  ngOnInit() {
    this.socket = new WebSocketStore();
  }

  connect() {
    this.socket.listen(msg => {
      this.messages[this.messages.length] = msg['message'];
    });
  }

  disconnect() {
    this.socket.close();
    this.messages = [];
  }

}