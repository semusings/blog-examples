import {environment} from '../environments/environment';

export class WebSocketStore {
  public wsActive = false;
  private ws: WebSocket | null = null;

  public constructor() {
  }

  public listen = (callback: (msg: any) => void) => {
    if (!environment.gotifyClientToken || !environment.gotifyUrl) {
      return;
    }

    const wsUrl = environment.gotifyUrl
      .replace('http', 'ws')
      .replace('https', 'wss');
    const ws = new WebSocket((wsUrl.endsWith('/') ? wsUrl : wsUrl + '/') + 'stream?token=' + environment.gotifyClientToken);

    ws.onerror = (e) => {
      this.wsActive = false;
      console.log('WebSocket connection errored', e);
    };

    ws.onmessage = (data) => callback(JSON.parse(data.data));

    ws.onclose = () => {
      this.wsActive = false;
    };

    this.ws = ws;
    this.wsActive = true;
  }

  public close = () => this.ws && this.ws.close();
}