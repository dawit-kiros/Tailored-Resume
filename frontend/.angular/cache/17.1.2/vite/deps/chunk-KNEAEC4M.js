import {
  VERSION as VERSION2,
  ɵzoneWrap
} from "./chunk-RJE4NSXN.js";
import {
  deleteApp,
  getApp,
  getApps,
  initializeApp,
  onLog,
  registerVersion,
  setLogLevel
} from "./chunk-EVMZEAM3.js";
import {
  Inject,
  InjectionToken,
  NgModule,
  Optional,
  PLATFORM_ID,
  VERSION,
  concatMap,
  distinct,
  from,
  setClassMetadata,
  timer,
  ɵɵdefineInjector,
  ɵɵdefineNgModule,
  ɵɵinject
} from "./chunk-IHRRZT46.js";

// node_modules/@angular/fire/fesm2022/angular-fire-app.mjs
var FirebaseApp = class {
  constructor(app) {
    return app;
  }
};
var FirebaseApps = class {
  constructor() {
    return getApps();
  }
};
var firebaseApp$ = timer(0, 300).pipe(concatMap(() => from(getApps())), distinct());
function defaultFirebaseAppFactory(provided) {
  if (provided && provided.length === 1) {
    return provided[0];
  }
  return new FirebaseApp(getApp());
}
var PROVIDED_FIREBASE_APPS = new InjectionToken("angularfire2._apps");
var DEFAULT_FIREBASE_APP_PROVIDER = {
  provide: FirebaseApp,
  useFactory: defaultFirebaseAppFactory,
  deps: [[new Optional(), PROVIDED_FIREBASE_APPS]]
};
var FIREBASE_APPS_PROVIDER = {
  provide: FirebaseApps,
  deps: [[new Optional(), PROVIDED_FIREBASE_APPS]]
};
var FirebaseAppModule = class _FirebaseAppModule {
  // eslint-disable-next-line @typescript-eslint/ban-types
  constructor(platformId) {
    registerVersion("angularfire", VERSION2.full, "core");
    registerVersion("angularfire", VERSION2.full, "app");
    registerVersion("angular", VERSION.full, platformId.toString());
  }
  static ɵfac = function FirebaseAppModule_Factory(t) {
    return new (t || _FirebaseAppModule)(ɵɵinject(PLATFORM_ID));
  };
  static ɵmod = ɵɵdefineNgModule({
    type: _FirebaseAppModule
  });
  static ɵinj = ɵɵdefineInjector({
    providers: [DEFAULT_FIREBASE_APP_PROVIDER, FIREBASE_APPS_PROVIDER]
  });
};
(() => {
  (typeof ngDevMode === "undefined" || ngDevMode) && setClassMetadata(FirebaseAppModule, [{
    type: NgModule,
    args: [{
      providers: [DEFAULT_FIREBASE_APP_PROVIDER, FIREBASE_APPS_PROVIDER]
    }]
  }], () => [{
    type: Object,
    decorators: [{
      type: Inject,
      args: [PLATFORM_ID]
    }]
  }], null);
})();
var deleteApp2 = ɵzoneWrap(deleteApp, true);
var getApp2 = ɵzoneWrap(getApp, true);
var getApps2 = ɵzoneWrap(getApps, true);
var initializeApp2 = ɵzoneWrap(initializeApp, true);
var onLog2 = ɵzoneWrap(onLog, true);
var registerVersion2 = ɵzoneWrap(registerVersion, true);
var setLogLevel2 = ɵzoneWrap(setLogLevel, true);

export {
  FirebaseApp,
  FirebaseApps
};
//# sourceMappingURL=chunk-KNEAEC4M.js.map
