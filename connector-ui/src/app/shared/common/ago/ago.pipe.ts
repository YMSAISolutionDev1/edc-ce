import {Pipe, PipeTransform} from '@angular/core';
import {Observable, concat, interval, of} from 'rxjs';
import {distinctUntilChanged, map} from 'rxjs/operators';
import {TranslateService} from '@ngx-translate/core';
import {formatDateAgo} from './formatDateAgo';

/**
 * Displays a date as estimated relative time (e.g. "3 days ago").
 */
@Pipe({name: 'ago'})
export class AgoPipe implements PipeTransform {
  interval$ = concat(of({}), interval(3000));

  constructor(private translateService: TranslateService) {}

  transform(date?: Date | null): Observable<string> {
    return this.interval$.pipe(
      map(() => formatDateAgo(date, this.translateService.currentLang)),
      distinctUntilChanged(),
    );
  }
}
