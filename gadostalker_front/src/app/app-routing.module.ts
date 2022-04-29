import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent} from '../app/component/login/login.component';
import { CriarContaComponent} from '../app/component/criar-conta/criar-conta.component';
import { RecuperarSenhaComponent } from '../app/component/recuperar-senha/recuperar-senha.component';
import { HomeComponent } from '../app/component/home/home.component';
import { AnunciosComponent } from '../app/component/anuncios/anuncios.component';
const routes: Routes = [
  { path: '', component: LoginComponent, pathMatch:'full' },
  { path: 'login', component: LoginComponent },
  { path: 'criar-conta', component: CriarContaComponent },
  { path: 'recuperar-senha', component: RecuperarSenhaComponent },
  { path: 'home', component: HomeComponent },
  { path: 'anuncios', component: AnunciosComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
